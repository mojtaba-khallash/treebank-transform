In the name of Allah

------------------------------
TreebankTransform version 1.0
      14 January 2013
------------------------------

This is the README for the "TreebankTransform" package that is a helper tools for 
tranforming input conll file to desire formats. This package has been developed by 
Mojtaba Khallash (mkhallash@gmail.com) from Iran University of Science and 
Technology (IUST).

The home page for the project is:
	http://nlp.iust.ac.ir

The code is available on Github at:
	https://github.com/mojtaba-khallash/treebank-transform
	
If you want to use this software for research, please refer to this web address 
in your papers.

-------------------------

The package can be used freely for non-commercial research and educational 
purposes. It comes with no  warranty, but we welcome all comments, bug reports, 
and suggestions for improvements.

------------------
Table of contents
------------------

1. Compiling

2. Example of usage

3. Running the package
   a. Global Transforms
   b. Transform that Affect Wordform and Lemma Column
   c. Transform that Affect POS and CPOS Column
   d. Transform that Affect FEATS Column
   e. Transform that Affect DEPREL and Head Column

4. References

----------------
1. Compiling
----------------

Requirements:
* Version 1.7 or later of the Java 2 SDK (http://java.sun.com)
  You must add java binary file to system path. In linux, your
  can open ~/.bashrc file and append this line:
    PATH=$PATH:/<address-of-bin-folder-of-JRE>

To compile the code, first decompress the package:

in linux:
$ tar -xvzf TreebankTransform.tgz
$ cd TreebankTransform
$ sh compile_all.sh

in windows:
- decompress the TreebankTransform.zip
- compile.bat

You can open the all projects in NetBeans 7.1 (or maybe later) too.

---------------------
2. Example of Usage
---------------------

For mark compund verb in this package use "Valency Lexicon Ver. 2.2" [1] (can be 
download freely from http://dadegan.ir/en).

-------------------------
3. Running the package
-------------------------

This package run in gui mode. simple double click on jar file or run the 
following command:

> java -jar TreebankTransform.jar

----------------------
3a. Global Transforms
----------------------

Two options exist:
1) Change direction of word (Left to Right - Right to Left): This transform used 
   when want to increase diversity of baseline parsers for have a good ensemble 
   system.
	
2) Mark Compound Verb: In annotation of persian dependency treebank, elements of 
   compound verbs marked as separate words. This option by using "Valency 
   Lexicon Ver. 2.2" find compound verbs and mark as a word.

----------------------------------------------------
3b. Transform that Affect Wordform and Lemma Column
----------------------------------------------------

Three options exist:
1) Transform annotation of numbers: This option can be used to replace each 
   number in Wordform and Lemma column by a constant.
    - Normal: Replace each number by "<num>" label
    - Bining: 	<num-bin0>	the number 0 and numbers ending with 00
                <num-bin1>	the number 1 and numbers ending with 01
                <num-bin2>	the number 2 and numbers ending with 02
                <num-bin3>	the numbers 3-10 and those ending with 03-10
                <num-bin4>	the numbers, and numbers ending with, 11-99
                <num-bin5>	all other number tokens
   This transform used for reduce data sparsity of lexical data.
	
2) Copy Lemma in Wordform: This option used for reduce data sparsity of lexical 
   data.

3) Remove Space: In annotation of persian dependency treebank, words can have 
   space that not permit in CoNLL format and some tools that use space delimeter 
   cannot run on this treebank. this option replace all space by underline (_) 
   character.

-----------------------------------------------
3c. Transform that Affect POS and CPOS Column
-----------------------------------------------

Two options exist:
1) Copy POS to CPOS
2) Copy CPOS to POS

---------------------------------------
3d. Transform that Affect FEATS Column
---------------------------------------

* FEATS column contains key=value pairs of attributes that separate by vertical 
  bar (|) and if no attribute exist, an underline (_) insert.

Two options exist:
1) Remove attribute: In this option you can add list of keys that want to remove. 
   if you want remove all attribute just enter "all".

2) Add attribute: In this option you can add list of keys that want to add.

* If you want remove all attributes except one off them, you can insert "all" to 
   remove list and "<your-attribute>" to add list.

-------------------------------------------------
3e. Transform that Affect DEPREL and Head Column
-------------------------------------------------

Three options exist:
1) Transform Ra Notation: This option is a bit different from the original treebank. 
   In generated version by this option, the direct object structure representation has
   been changed. In this representation, "ra" is not the head of the object word. 
   Instead, "ra" is regarded as the "case marker" for the direct object (dependent 
   of "ra" in the original representation). The conversion has been done automatically;
   therefore, there may be some potential errors.

2) Remove: This options used for remove content of DEPREL and HEAD column and 
   replace by underline (_) so that predict by parser.

3) Set All Head Deprel to ROOT: This options unified DEPREL of each word that 
   have HEAD=0 to "ROOT".

------------
References
------------
[1]	M. S. Rasooli, et al., "A Syntactic Valency Lexicon for Persian Verbs 
    The First Steps towards Persian Dependency Treebank", 5th Language & 
    Technology Conference (LTC): Human Language Technologies as a  Challenge for 
    Computer Science and Linguistics, Poznan, Poland, pp. 227-231, 2011.