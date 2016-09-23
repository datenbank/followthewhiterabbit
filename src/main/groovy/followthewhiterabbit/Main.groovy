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
		def cruncher = new MD5Cruncher()
		
		def cruncherAnagram = new AnagramCruncher()
		
		/*
		 * do the work
		 */
		def allWords = download.toList(HTTP_WORDLIST)
		def candiateWord = wordCandidate.filter(allWords, ANAGRAM)
		
		/*
		 * narrow it down (all though a md5 brute force is faster, but let's have some fun before turning to md5)
		 */
		def possibleWords = cruncherAnagram.crunchTheSecret(candiateWord, ANAGRAM)
		
		
		println "\nList of possible secrets:"
		def i = 1
		possibleWords.each {
			println "$i|"+it[0]+" "+it[1]+" "+it[2]
			i++
		}
	
		
		/*
		 * Find the secret by matching md5
		 */
		def secret = cruncher.crunchTheSecret(possibleWords, HASH)
		
		
		
		/*
		 * print the result
		 */
		println "*********** SECRET IS **************"
		println "$secret"
		println "************************************"
	}
}
