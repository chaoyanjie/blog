import urllib
import urllib2
import json
    
def http_post():
    url='aa'
    values ={    }
    jdata=json.dumps(values) 
    req = urllib2.Request(url, jdata) 
    response = urllib2.urlopen(req) 
    return response.read()
resp = http_post()
print resp