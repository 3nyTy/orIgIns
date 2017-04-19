 /***Implement a cache application in java. Which stores student results information rank wise.

StudentResults

Rank    Name             Marks         Percentage
1        Chinna             80            80%
2        Mahi            70            75%

StudentResults should be inserted into cache rank wise.

public interface MyCache{

public void addCache(StudentResults std);
public StudentResults readFromCache(String rank);
public void removeFromCache(String rank);

}

Business Rules:
1. While adding we have to check wether cache exists already or not,if not you have to create only one object of cache and add first element into cache.
2. If cache size is 20 or more than 20, then remove least used element from cache and add new element into cache.
3. While reading if cache is empty, read first 10 student results from text file into cache.
****
*/


package com.JP;

public interface StudentResultsCache {
	public void addCache(Student std);
	public Student readFromCache(int rank);
	public void removeFromCache(int rank);
	

}
