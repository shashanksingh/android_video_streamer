import os
import urllib
import webapp2

import webapp2_extras.appengine.auth.models
from webapp2_extras import security
from webapp2_extras.appengine.auth.models import User

from google.appengine.ext import blobstore
from google.appengine.ext.webapp import blobstore_handlers

class MainHandler(webapp2.RequestHandler):
  def get(self):
    upload_url = blobstore.create_upload_url('/upload')
    self.response.out.write('<html><body>')
    self.response.out.write('<form action="%s" method="POST" enctype="multipart/form-data">' % upload_url)
    self.response.out.write("""Upload File: <input type="file" name="file"><br> <input type="submit"
        name="submit" value="Submit"> </form></body></html>""")

class UploadHandler(blobstore_handlers.BlobstoreUploadHandler):
  def post(self):
    upload_files = self.get_uploads('file')  # 'file' is file upload field in the form
    blob_info = upload_files[0]
    self.redirect('/serve/%s' % blob_info.key())

class ServeHandler(blobstore_handlers.BlobstoreDownloadHandler):
  def get(self, resource):
    resource = str(urllib.unquote(resource))
    blob_info = blobstore.BlobInfo.get(resource)
    self.send_blob(blob_info)

class LoginHandler(webapp2.RequestHandler):
  def post(self):
    """
    username: Get the username from POST dict
    password: Get the password from POST dict
    """
    username = self.request.POST.get('username')
    password = self.request.POST.get('password')
    # Try to login user with password
    # Raises InvalidAuthIdError if user is not found
    # Raises InvalidPasswordError if provided password doesn't match with specified user
    try:
      self.auth.get_user_by_password(username, password)
    except (InvalidAuthIdError, InvalidPasswordError), e:
      # Returns error message to self.response.write in the BaseHandler.dispatcher
      # Currently no message is attached to the exceptions
      return e

class SignupHandler(webapp2.RequestHandler):
  def post(self):
    """
    username: Get the username from POST dict
    password: Get the password from POST dict
    """
    username = self.request.POST.get('username')
    password = self.request.POST.get('password')
    # Try to login user with password
    # Raises InvalidAuthIdError if user is not found
    # Raises InvalidPasswordError if provided password doesn't match with specified user
    try:
      self.auth.create_user_by_password(username, password)
    except (InvalidAuthIdError, InvalidPasswordError), e:
      # Returns error message to self.response.write in the BaseHandler.dispatcher
      # Currently no message is attached to the exceptions
      return e  

app = webapp2.WSGIApplication([('/', MainHandler),
                               ('/upload', UploadHandler),
                               ('/serve/([^/]+)?', ServeHandler),
                               ('/signup',SignupHandler),
                               ('/login',LoginHandler)],
                              debug=True)
