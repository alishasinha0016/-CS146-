
HW1:
In this program, we were supposed to write a code in Java and Python that checks whether the input string is
palindrome. A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

In this program, I have created a function,checkPalindrome(), that accepts the string passed as an argument. I have first converted the string into lowercase. Then, iterating through characters of the given string using a for loop, I extracted each character and created two new strings by concatenating them (based on the condition for the acceptable character, that is, alphanumeric character)  forward and backward (reverse).

The function then returns true or false based on whether the two new forward and backward concatenated strings are equal or not. Thereby, it returns if the given string is a palindrome or not.

HW2: 
In this program, it was mentioned that we have been given an API bool isBadVersion(version) 
which returns whether the version is bad. In this program, we must Implement a function to find the bad version. 

Here, I have used left, right, and mid integer variables that store the index value of the element 
in a data structure like an array. The size of the array is 'n', which is passed as a parameter to the function BadVersion(). 
I have applied binary search logic where I am breaking the data structure, like an array, into smaller 
parts by eliminating elements and getting to the correct element.
In the end, the function again checks if the resultant index has a bad version. If yes, it returns 
the index value; otherwise, it returns -1 in case no bad version is present.
