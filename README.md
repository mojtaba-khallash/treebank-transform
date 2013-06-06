In the name of Allah

TreebankTransform version 1.0
===================
      14 January 2013

This is the README for the *"TreebankTransform" package* that is a helper tools for 
tranforming input conll file to desire formats. This package has been developed by 
[Mojtaba Khallash] (mailto: mkhallash@gmail.com) from _Iran University of Science and 
Technology (IUST)_.

The home page for the project is:
  http://nlp.iust.ac.ir
	
If you want to use this software for research, please refer to this web address 
in your papers.

The package can be used freely for non-commercial research and educational 
purposes. It comes with no  warranty, but we welcome all comments, bug reports, 
and suggestions for improvements.

Table of contents
------------------

1. Compiling
2. Example of usage
3. Running the package
   <ul>
   a. Global Transforms<br/>
   b. Transform that Affect Wordform and Lemma Column<br/>
   c. Transform that Affect POS and CPOS Column<br/>
   d. Transform that Affect FEATS Column<br/>
   e. Transform that Affect DEPREL and Head Column
   <ul>
4. References

1. Compiling
----------------

Requirements:
* Version 1.7 or later of the [Java 2 SDK] (http://java.sun.com)
You must add java binary file to system path. <br/>In linux, your
can open `~/.bashrc` file and append this line:
`PATH=$PATH:/<address-of-bin-folder-of-JRE>`

To compile the code, first decompress the package:

in linux:
> tar -xvzf TreebankTransform.tgz<br/>
> cd TreebankTransform<br/>
> sh compile_all.sh

in windows:
> decompress the TreebankTransform.zip<br/>
> compile.bat

You can open the all projects in NetBeans 7.1 (or maybe later) too.

2. Example of Usage
---------------------

For mark compund verb in this package use "[Valency Lexicon Ver. 2.2] (http://dadegan.ir/en)" [1].

3. Running the package
-------------------------

This package run in gui mode. simple double click on jar file or run the 
following command:

> java -jar TreebankTransform.jar

3a. Global Transforms
----------------------

Two options exist:<br/>
1) Change direction of word (Left to Right - Right to Left):
    <ul>
      This transform used when want to increase diversity of baseline parsers for have 
      a good ensemble system.
   </ul>
2) Mark Compound Verb:
    <ul>
      In annotation of persian dependency treebank, elements of 
      compound verbs marked as separate words. This option by using "Valency 
      Lexicon Ver. 2.2" find compound verbs and mark as a word.
    </ul>

3b. Transform that Affect Wordform and Lemma Column
----------------------------------------------------

Three options exist:<br/>
1) Transform annotation of numbers: 
    <ul>
      This option can be used to replace each number in _Wordform_ and _Lemma_ column by a constant.
        <table>
          <tr><td>Normal</td><td>Replace each number by <code>num</code> label</td></tr>
          <tr>
            <td>Bining</td>
            <td>
                <code>num-bin0</code>  the number 0 and numbers ending with 00<br/>
                <code>num-bin1</code>  the number 1 and numbers ending with 01<br/>
                <code>num-bin2</code>	 the number 2 and numbers ending with 02<br/>
                <code>num-bin3</code>	 the numbers 3-10 and those ending with 03-10<br/>
                <code>num-bin4</code>	 the numbers, and numbers ending with, 11-99<br/>
                <code>num-bin5</code>	 all other number tokens
            </td>
          </tr>
        </table>
        This transform used for reduce data sparsity of lexical data.
      </ul>
	
2) Copy Lemma in Wordform:
      <ul>This option used for reduce data sparsity of lexical data.</ul>

3) Remove Space: 
      <ul>
        In annotation of persian dependency treebank, words can have space that not permit in 
        CoNLL format and some tools that use space delimeter cannot run on this treebank. this 
        option replace all space by underline `_` character.
      </ul>

3c. Transform that Affect POS and CPOS Column
-----------------------------------------------

Two options exist:<br/>
1) Copy POS to CPOS<br/>
2) Copy CPOS to POS

3d. Transform that Affect FEATS Column
---------------------------------------

FEATS column contains _key=value_ pairs of attributes that separate by vertical 
bar `|` and if no attribute exist, an underline `_` insert.<br/>

Two options exist:<br/>
1) Remove attribute: 
    <ul>
      In this option you can add list of keys that want to remove. 
      if you want remove all attribute just enter <code>all</code>.
    </ul>

2) Add attribute: 
    <ul>In this option you can add list of keys that want to add.</ul>
If you want remove all attributes except one off them, you can insert `all` to 
remove list and `your-attribute` to add list.


3e. Transform that Affect DEPREL and Head Column
-------------------------------------------------

Three options exist:<br/>
1) Transform Ra notation: 
    <ul>
      This option is a bit different from the original treebank. <br/>
      In generated version by this option, the direct object structure representation has
      been changed. In this representation, <b>ra</b> is not the head of the object word. 
      Instead, "ra" is regarded as the <b>case marker</b> for the direct object (dependent 
      of "ra" in the original representation). The conversion has been done automatically;
      therefore, there may be some potential errors.
    </ul>

2) Remove: 
    <ul>
      This options used for remove content of DEPREL and HEAD column and 
      replace by underline <code>_</code> so that predict by parser.
    </ul>

3) Set All Head Deprel to ROOT: 
    <ul>This options unified <b>DEPREL</b> of each word that have <code>HEAD=0</code> to <code>ROOT</code>.</ul>

4. References
------------
[1]	M. S. Rasooli, et al., "A Syntactic Valency Lexicon for Persian Verbs 
The First Steps towards Persian Dependency Treebank", 5th Language & 
Technology Conference (LTC): Human Language Technologies as a  Challenge for 
Computer Science and Linguistics, Poznan, Poland, pp. 227-231, 2011.
