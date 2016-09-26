package followthewhiterabbit

import java.security.MessageDigest

class MD5Cruncher {

	def stringTohash(s) {
		def m = MessageDigest.getInstance("MD5");
		m.update(s.getBytes(), 0, s.length());
		return new BigInteger(1, m.digest()).toString(16)
	}

	def crunch(words, hash) {
		def secret = ""
		
		if(stringTohash(words[0]+" "+words[1]+" "+words[2])==hash)
			secret = words[0]+" "+words[1]+" "+words[2]

		if(stringTohash(words[0]+" "+words[2]+" "+words[1])==hash)
			secret = words[0]+" "+words[2]+" "+words[1]

		if(stringTohash(words[1]+" "+words[0]+" "+words[2])==hash)
			secret = words[1]+" "+words[0]+" "+words[2]

		if(stringTohash(words[1]+" "+words[2]+" "+words[0])==hash)
			secret = words[1]+" "+words[2]+" "+words[0]

		if(stringTohash(words[2]+" "+words[0]+" "+words[1])==hash)
			secret = words[2]+" "+words[0]+" "+words[1]

		if(stringTohash(words[2]+" "+words[1]+" "+words[0])==hash)
			secret = words[2]+" "+words[1]+" "+words[0]
			
			
		return secret
	}

	
}
