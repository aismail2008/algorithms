package com.code.test.problemset.companies.google;

public class AlgorithmsRound1 {

    public static void main(String[] args) {

    }

    public static void solve() {

    }
}
 /*
Please use this Google doc during your interview (your interviewer will see what you write here). To free your hands for typing, we recommend using a headset or speakerphone.

Hello

UTF-8
0xxx xxxx 1-byte symbol
10xx xxxx continuation
110x xxxx 2-bytes symbol start
1110 xxxx 3-bytes symbol start
…
1111 1111 8-bytes symbol start

1110 xxxx 10xx xxxx 10xx xxxx -> 3-bytes symbol
10           11           12

-> input : byte[] inp
-> output : the beginning/prefix

// bytes = 10 , n = 6
public byte[] prefix(byte[] doc, int maxNubmerBytes){
	if(maxNubmerBytes >= doc.length())
		return doc;

	List<Byte> byteList  = new ArrayList<>();
	int i = 0;
	while(i < doc.length){ // i = 2; n = 6
		int symbolBytes = symbolCount(byte[i]); // 2
		if (symbolBytes <= n){
			byteList.add(Array.subArray(i, i + symbolBytes))
			i += symbolBytes;
			n - symbolBytes;
}else{
	break;
}
}
byteList.toArray();
}


//
if byte at index n it is a start of new symbol or end of a symbol
	cut here and return;
else if current is “10xx xxxx continuation”
	go back one by one skipping “10xx xxxx continuation” untill start of syumolb and retur from 0 to that index







// 4 digit safe


lock: xxxx
10,000

the sequence of digits
0 - 9

0 - 1
1
2
..
9

String nubmers = “0123456789”

//Set<String> permutaions

generateSque{prefix, length}{
	if()

	add to prefix number from 0 -9
	generateSque( pref, lenght - 1)
}

0123456

0000 0001 0002

constraint:
correct.
Short as possible. => solution 10004


 */