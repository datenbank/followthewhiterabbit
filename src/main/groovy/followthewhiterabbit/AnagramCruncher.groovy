package followthewhiterabbit

class AnagramCruncher {
	
	
	def crunch(words, anagram) {
		
		def secret = words[0]+" "+words[1]+" "+words[2]
		
		def anagramList = []
		
		anagram.each {
			anagramList << it
		}
		
		secret.each { s ->
			anagramList.remove(s)
		}
		
		return anagramList.size()
		
		
	}
	

	
	
}
