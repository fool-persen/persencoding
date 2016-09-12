#!/usr/bin/python

import os

for i in range(10000, 10003):
	file = open('%d' %i, 'w')
	file.close()
	if i%10000 == 0 :
		print 'create : %dw' %(i/10000)