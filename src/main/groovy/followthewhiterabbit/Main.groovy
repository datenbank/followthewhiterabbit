package followthewhiterabbit

class Main {

	static HTTP_WORDLIST = 'http://followthewhiterabbit.trustpilot.com/cs/wordlist'
	static HASH = "4624d200580677270a54ccff86b9610e"
	static ANAGRAM = "poultry outwits ants"


	def static main(args) {
		/*
		 * init the instances 
		 */
		def download = new HttpDownload()
		def wordCandidate = new WordCandidateCombination()
		def crunher = new MD5Cruncher()
		
		
		/*
		 * do the work
		 */
		def allWords = download.toList(HTTP_WORDLIST)
		def candiateWord = wordCandidate.filter(allWords, ANAGRAM)
		def secret = crunher.crunchTheSecret(candiateWord, HASH)
		
		
		/*
		 * print the result
		 */
		println "***********SECRET*******************"
		println "$secret"
		println "************************************"
	}
}
