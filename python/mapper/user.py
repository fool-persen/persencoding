__author__ = 'persen'
from sqlalchemy import *
from sqlalchemy.orm import *
from sqlalchemy.ext.declarative import declarative_base
import json
from datetime import datetime


Base = declarative_base()

class Users(Base):
    __tablename__ = 'users'

    user_id = Column(Integer, primary_key = True)
    name = Column(String(40))
    age = Column(Integer)
    password = Column(String(40))

    def __init__(self, user_id, name, age, password):
        self.user_id = user_id
        self.name = name
        self.age = age
        self.password = password

    def __repr__(self):
        return "<users('%d', '%s', '%d', '%s')>" % (self.user_id, self.name, self.age, self.password)

from sqlalchemy.ext.declarative import DeclarativeMeta
class AlchemyEncoder(json.JSONEncoder):
    def default(self, obj):
        if isinstance(obj.__class__, DeclarativeMeta):
            # an SQLAlchemy class
            fields = {}
            for field in [x for x in dir(obj) if not x.startswith('_') and x != 'metadata']:
                data = obj.__getattribute__(field)
                try:
                    if isinstance(data, datetime):
                        data=data.strftime('%Y-%m-%d %H:%M:%S')
                    json.dumps(data) # this will fail on non-encodable values, like other classes
                    fields[field] = data
                except TypeError:
                    fields[field] = None
            # a json-encodable dict
            return fields

        return json.JSONEncoder.default(self, obj)

def new_alchemy_encoder():
    _visited_objs = []
    class AlchemyEncoder(json.JSONEncoder):
        def default(self, obj):
            if isinstance(obj.__class__, DeclarativeMeta):
                # don't re-visit self
                if obj in _visited_objs:
                    return None
                _visited_objs.append(obj)

                # an SQLAlchemy class
                fields = {}
                for field in [x for x in dir(obj) if not x.startswith('_') and x != 'metadata']:
                    data = obj.__getattribute__(field)
                    try:
                        if isinstance(data, datetime):
                            data=data.strftime('%Y-%m-%d %H:%M:%S')
                        json.dumps(data) # this will fail on non-encodable values, like other classes
                        fields[field] = data
                    except TypeError:
                        fields[field] = None
                return fields

            return json.JSONEncoder.default(self, obj)
    return AlchemyEncoder