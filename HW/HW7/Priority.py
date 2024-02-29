class Priority:
    def priorityMinMeeting(self, intervals):
        if not intervals or len(intervals) < 1 or len(intervals) > 10**4:
            return -1
        for i in range(len(intervals)):
            if intervals[i][0] < 0:
                return -1
            for j in range(len(intervals[i])):
                if intervals[j][1] > 10**6:
                    return -1

        end_index = 0
        count = 0
        self.sortByStartTime(intervals)

        end_times = []
        for interval in intervals:
            end_times.append(interval[1])
        end_times.sort()

        for start, _ in intervals:
            if start < end_times[end_index]:
                count += 1
            else:
                end_index += 1

        return count


    def sortByStartTime(self, intervals):
        for i in range(len(intervals)):
            for j in range(i + 1, len(intervals)):
                if intervals[i][0] > intervals[j][0]:
                    intervals[i], intervals[j] = intervals[j], intervals[i]


def main():
    intervals1 = [[0, 30], [5, 10], [15, 20]]
    intervals2 = [[0, 1], [1, 2], [2, 3]]
    priOb = Priority()
    result1 = priOb.priorityMinMeeting(intervals1)
    result2 = priOb.priorityMinMeeting(intervals2)
    if result1 != -1 or result2 != -1:
        print(result1)
        print(result2)
    else:
        print ("invalid")

if __name__ == "__main__":
    main()
