package com.seth.mikeQuestions

object ShortestTimeBetweenTimes {
    //HH::MM
    fun ShortestTimeBetweenTimes(times: List<String>): Int? {
        if (times.size <= 1) return null
        val timeResetInMinutes = 1440
        var shortestTime = Integer.MAX_VALUE
        val timeInMinutesSorted = sortTimes(convertToMinutes(times))
        for (i in times.indices) {
            //check if next is shortest
            if (i != times.size - 1) {
                val timeDiff = timeInMinutesSorted[i + 1] - timeInMinutesSorted[i]
                if (timeDiff < shortestTime) shortestTime = timeDiff
            }
            //check if last to first is shortest
            else {
                val timeDiff = timeResetInMinutes - timeInMinutesSorted[i] + timeInMinutesSorted[0]
                if (timeDiff < shortestTime) shortestTime = timeDiff
            }
        }
        return shortestTime
    }

    fun convertToMinutes(times: List<String>): List<Int> {
        val timesInMinutes = mutableListOf<Int>()
        times.forEach { timesInMinutes.add(Integer.valueOf(it.substring(0, 2)) * 60 + Integer.valueOf(it.substring(4, 6)))}
        return timesInMinutes
    }

    fun sortTimes(times: List<Int>) : List<Int> {
        return times.sorted()
    }
}