__author__ = 'persen'

import os

import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web

from tornado.options import options, define
define('port', default=8000, help='run on the given port', type=int)

class IndexHandle(tornado.web.RequestHandler):
    def get(self):
        self.render('index.html')

if __name__ == '__main__':
    tornado.options.parse_command_line()
    app = tornado.web.Application(
        handlers=[(r'/', IndexHandle)],
        template_path = os.path.join(os.path.dirname(__file__), "templates")
    )