package followthewhiterabbit

import java.security.MessageDigest

class MD5Cruncher {

		def stringTohash(s) {
		def m = MessageDigest.getInstance("MD5");
		m.update(s.getBytes(), 0, s.length());
		return new BigInteger(1, m.digest()).toString(16)
	}
	
	
	def crunchTheSecret(words, hash) {
		println "Start crunching..."

		def i = 0
		def x = 0
		def secret = ""
		def total = words.size()
		words.each {
			if(secret == "") {
				if(i==10000) {
					i=0 //reset
					print "\rWorked $x combinations of $total"
				}				
	
				if(stringTohash(it[0]+" "+it[1]+" "+it[2])==hash)
					secret = it[0]+" "+it[1]+" "+it[2]
			}

			i++
			x++
		}
		if(secret=="")	
			println "\nFinished, no match"
		else 
			println "\nFinished, OK"
		
		return secret
	}

}
