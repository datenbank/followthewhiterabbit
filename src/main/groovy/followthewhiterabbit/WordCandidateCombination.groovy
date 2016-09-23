package followthewhiterabbit

class WordCandidateCombination {

	def filter(words, anagram) {

		/*
		 * Final list to return
		 */
		def wordsCombination = []


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


		//Create a word combination list (cross join the lists)
		def total=wordsPositionOne.size()
		def cnt=1
		wordsPositionOne.each { one ->

			wordsPositionTwo.each { two ->
				wordsPositionThree.each { three ->
					wordsCombination << [one, two, three]
				}
			}


			print "\rCreating word combinations: $cnt of $total loops"

			cnt++
		}

		println "\nWord combination list size: "+wordsCombination.size()

		return wordsCombination
	}
}
