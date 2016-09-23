package followthewhiterabbit

class AnagramCruncher {
	
	
	def matchCharacters(secret, anagram) {
		
		def anagramList = []
		
		anagram.each {
			anagramList << it
		}
		
		secret.each { s ->
			anagramList.remove(s)
		}
		
		return anagramList.size()
		
		
	}
	
	
	
	def crunchTheSecret(words, anagram) {
		
		println "Start crunching Anagram..."
		def posibleWords = []
		
		 
		def i = 0
		def x = 0
		def total = words.size()
		
		words.each {
			
			if(i==10000) {
				i=0 //reset
				print "\rWorked $x combinations of $total found ${posibleWords.size()} matches"
			}
			
			def secret = it[0]+" "+it[1]+" "+it[2]
			
			def status = matchCharacters(secret, anagram)
			
			if(status==0) {	
				posibleWords << it
			}
				
			i++
			x++
		}
		return posibleWords
	}
	
	
	
}
