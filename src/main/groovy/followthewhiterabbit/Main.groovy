package followthewhiterabbit

class Main {

	static HTTP_WORDLIST = 'http://followthewhiterabbit.trustpilot.com/cs/wordlist'
	static HASH = "4624d200580677270a54ccff86b9610e"
	static ANAGRAM = "poultry outwits ants"


	def static main(args) {
		
		def start = System.currentTimeMillis()
		
		/*
		 * init the instances 
		 */
		def download = new HttpDownload()
		def wordCandidate = new WordCandidateCombination()
		
		/*
		 * do the work
		 */
		def allWords = download.toList(HTTP_WORDLIST)
		def secret = wordCandidate.filterLoopAndCrunch(allWords, ANAGRAM, HASH)
		
		
		println "\n*********Secret is**********"
		println "$secret"
		println "****************************"
		
		def seconds = (System.currentTimeMillis() - start) / 1000
		def min = seconds / 60
		println "Took $seconds seconds / $min minutes to find the secret"
	}
}
