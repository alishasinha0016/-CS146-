In this program, BFS, Bredth Firts Search Graph is used. In the method floodFill(), LinkedList<int[]> is used that acts like a queue that uses FIFO (First In First Out) principle, i.e. the element inserted at first in the list, is the first element to be removed from the list.
The method, floodFill(), has the while loop that continues as long as the queue is not empty. Inside the loop, it dequeues a pixel (r, c) from the front of the queue and updates its color to the new color newColor.
For each pixel (r, c) dequeued from the queue, it checks its neighboring pixels in the up, down, left, and right directions. If a neighboring pixel has the same color as the originalColor, it is added to the queue to be processed later. This way matrix is floodfilled. 
We have the constraints: 
    m == image.length
    n == image[i].length
    1 <= m, n <= 50
    0 <= image[i][j], color < 216
    0 <= sr < m
    0 <= sc < n
Helper methods are used the check the validity. If any of the constraints are not matched, an error message is printed on the screen.
