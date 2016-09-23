package followthewhiterabbit

class HttpDownload {
	
	def lines = []
	
	def toList(http) {
		
		println "Reading words list from: $http"
		def wl = new URL(http).getText()
		wl.eachLine { lines << it }
		
		return lines
		
	}
	

}
