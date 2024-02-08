Lab1:
In this program, given an array of integers nums and an integer target, we had to return indices of the two numbers such that they add up to target.
We could assume that each input would have exactly one solution, and you may not use the same element twice.

In the program, I have used HashMap to store the key, the element in the array, and the value, that is, the index of that element in the array. Iterating through the passed array using the for loop, I have applied the complement method to find the index number of the required elements if they are present. Meaning I first calculate the difference or complement by subtracting each element in the array from the target value. This difference/complement is then checked if it is preset as a key in the HashMap. If yes, then it means that we have found the pair. We then store both the element's index number, which in this case is the value of the required key, in an ArrayList, which, in the end, is returned to the caller. Otherwise, the search continues until we find the index pair or till the loop ends.

In the main function, we check the size of the ArrayList. If it is greater than 0, then we print the ArrayList. Otherwise, we print the "No indices found" message.

Lab2:
In this program, we were given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Here, I have used a HashMap to store each character of the string as a key and the frequency of the character in that string as the value corresponding to that key. I have used three main loops. Loop 1 counts the frequency of each character in the string and adds it to the HashMap. In Loop 2, we iterate through the second string and count the frequency of every character of the string. Each time we encounter the character, we reduce the value of the corresponding key by 1. In both the loops, I have also added a condition so that the white space is not counted and added to the HashMap.
In the second loop, if the value of any key goes below 0, we return False. Using the third loop, we check if the values of all the keys in the HashMap are 0. If not, we return false to the caller. These conditions on loops 2 and 3 ensure that the two passed strings, s and t, have the same number of characters. Hence, they are anagrams of each other.


