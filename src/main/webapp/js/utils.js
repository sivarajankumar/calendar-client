function arrayRange(from, to) {
	var ar = new Array(to-from+1);
	var i;
	for (i=0; i<ar.length; i++) {
		ar[i] = from+i;
	}
	return ar;
};

function contextPath(absoluteUrl, tag) {
	return absoluteUrl.substr(0, absoluteUrl.lastIndexOf(tag));
};
