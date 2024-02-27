
class Priority:
    def priorityMinMeeting(self,intervals):
        if not intervals:
            return 0

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
    print(priOb.priorityMinMeeting(intervals1))
    print(priOb.priorityMinMeeting(intervals2))

if __name__ == "__main__":
    main()
