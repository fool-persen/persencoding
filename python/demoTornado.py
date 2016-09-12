import tornado.ioloop
import tornado.web
from dbTool import *
import json
from mapper import user

class MainHandler(tornado.web.RequestHandler):
    def get(self):
        db = dbTool()
        res = db.getUser()
        rows = []
        for row in res:
            #encodedjson = json.dumps(row, cls=user.AlchemyEncoder)
            #self.write(json.dumps(row, cls=user.AlchemyEncoder))
            rows.append(row)
        self.write(json.dumps(rows, cls=user.new_alchemy_encoder(), check_circular=false))

application = tornado.web.Application([
    (r"/", MainHandler),
])

if __name__ == "__main__":
    application.listen(8888)
    tornado.ioloop.IOLoop.instance().start()
