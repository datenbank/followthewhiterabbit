package followthewhiterabbit

class WordCandidateCombination {

	def filterLoopAndCrunch(words, anagram, hash) {

		/*
		 * Temp. list
		 */
		def wordsCharAndLength = []
		def wordsPositionOne = []
		def wordsPositionTwo = []
		def wordsPositionThree = []


		def anagramWordLength = []
		anagram.split(' ').each {
			anagramWordLength << it.length()
		}


		//Filter words based on characters should be in anagram and word length of anagram
		words.each { word ->
			def okCharsCnt = 0
			word.each { ch ->
				if(anagram.contains(ch)) {
					okCharsCnt++
				}
			}
			if(okCharsCnt==word.length() && anagramWordLength.contains(word.length())) {

				if(!wordsCharAndLength.contains(word)) {
					wordsCharAndLength << word
				}
			}
		}
		//Filter more... each word should match the anagram length
		wordsCharAndLength.each {
			if(it.length() == anagramWordLength[0]) {
				wordsPositionOne << it
			}
			if(it.length() == anagramWordLength[1]) {
				wordsPositionTwo << it
			}
			if(it.length() == anagramWordLength[2]) {
				wordsPositionThree << it
			}
		}

		
		def secret = ""

		//Create a word combination (cross join the lists)
		wordsPositionOne.each { one ->
			if(secret == "") { //only loop until we find the secret
				wordsPositionTwo.each { two ->
					wordsPositionThree.each { three ->
									
						def wordCombi = [one, two, three]
						def status = new AnagramCruncher().crunch(wordCombi, anagram)
						
						if(status==0) {
							println "Candidate words: $one $two $three"
						}
						
						def secretTmp = new MD5Cruncher().crunch(wordCombi, hash)					
						if(secretTmp != "") {
							secret = secretTmp
						}
					}
				}
			}

		}
		return secret


	}
}
