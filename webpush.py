import ftplib, os, sys

VALID_BRANCH = "rewrite"

if "false" in os.environ['TRAVIS_SECURE_ENV_VARS]:
	print "Secure vars not enabled, exiting..."
	sys.exit(0)

if "false" in os.environ['TRAVIS_PULL_REQUEST]:
	print "Build is a pull request, exiting..."
	sys.exit(0)
	
if not (VALID_BRANCH in os.environ['TRAVIS_BRANCH']):
	print "Build is not on VALID_BRANCH: "+VALID_BRANCH
	sys.exit(0)

VERSION = "1.2.0"
BUILD = (int(os.environ['TRAVIS_BUILD_NUMBER']) - 453) + 14
MCPE_VERSION = "0.12.1"
MCPC_VERSION = "1.8.8"
STABABILITY = "DEV"

def findJar():
	jar = "RedstoneLamp-"+VERSION+"-"+STABABILITY+".jar"
	path = "target/"+jar
	if os.path.exists(path):
		return (jar, path)
	else:
		print "Could not find JAR, path: "+path+" does not exist!"
		sys.exit(1)

addr = "redstonelamp.net"
user = os.environ['webPush_user']
passwd = os.environ['webPush_pass']
jarUpload, jarPath = findJar()

print "Connecting to "+addr+" ..."
f = ftplib.FTP(addr)
print "Logging in..."
d = f.login(user, passwd)
print "Response: "+d
print "Sending "+jarPath+" as "+jarUpload
r = f.storbinary("STOR "+jarPath, open(jarPath, 'rb'))
print "Response: "+r
print "Disconnecting..."
f.quit()
sys.exit(0)