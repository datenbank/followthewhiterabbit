package followthewhiterabbit

import java.security.MessageDigest

class MD5Cruncher {

	def stringTohash(s) {
		def m = MessageDigest.getInstance("MD5");
		m.update(s.getBytes(), 0, s.length());
		return new BigInteger(1, m.digest()).toString(16)
	}
	
	
	def crunchTheSecret(words, hash) {
		println "Start crunching MD5..."

		def i = 1
		def x = 1
		def secret = ""
		def total = words.size()
		words.each {
			if(secret == "") {
				if(i==1) {
					i=0 //reset
					print "\rWorked $x combinations of $total"
				}				
	
				if(stringTohash(it[0]+" "+it[1]+" "+it[2])==hash)
					secret = it[0]+" "+it[1]+" "+it[2]
					
				if(stringTohash(it[0]+" "+it[2]+" "+it[1])==hash)
					secret = it[0]+" "+it[2]+" "+it[1]
					
				if(stringTohash(it[1]+" "+it[0]+" "+it[2])==hash)
					secret = it[1]+" "+it[0]+" "+it[2]
					
				if(stringTohash(it[1]+" "+it[2]+" "+it[0])==hash)
					secret = it[1]+" "+it[2]+" "+it[0]
					
				if(stringTohash(it[2]+" "+it[0]+" "+it[1])==hash)
					secret = it[2]+" "+it[0]+" "+it[1]
					
				if(stringTohash(it[2]+" "+it[1]+" "+it[0])==hash)
					secret = it[2]+" "+it[1]+" "+it[0]
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
