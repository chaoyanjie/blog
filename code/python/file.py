#encoding:utf-8
file = open("E:\\data\\111.txt")
output = open('E:\\data\\112.txt', 'w')
while 1:
    line = file.readline()
    print line
    output.write(line)
    if not line:
        break
    pass # do something
file.close()
output.close()

