package com.seth.extra;

import java.util.*;
import java.util.stream.Collectors;

public class TopNCompetitors {
    public ArrayList<String> topNCompetitors(int numCompetitors,
                                             int topNCompetitors,
                                             List<String> competitors,
                                             int numReviews,
                                             List<String> reviews)
    {
        Map<String, OccurrenceOfCompetitor> occurrenceOfCompetitorMap = buildOccurrenceOfCompetitorMap(competitors, reviews);
        List<OccurrenceOfCompetitor> occurrenceOfCompetitorList = new ArrayList<>(occurrenceOfCompetitorMap.values());
        sort(occurrenceOfCompetitorList);
        return finalCompetitors(topNCompetitors, occurrenceOfCompetitorList);
    }

    private ArrayList<String> finalCompetitors(int topNCompetitors, List<OccurrenceOfCompetitor> occurrenceOfCompetitorList) {
        ArrayList<String> finalCompetitors = new ArrayList<>();
        for (int i = 0; i < topNCompetitors; i++) {
            if (i >= occurrenceOfCompetitorList.size()) {
                break;
            }
            finalCompetitors.add(occurrenceOfCompetitorList.get(i).name);
        }
        return finalCompetitors;
    }

    private void sort(List<OccurrenceOfCompetitor> occurrenceOfCompetitorList) {
        Collections.sort(occurrenceOfCompetitorList);
    }

    private Map<String, OccurrenceOfCompetitor> buildOccurrenceOfCompetitorMap (List<String> competitors, List<String> reviews) {
        Map<String, OccurrenceOfCompetitor> occurrenceOfCompetitorMap = new HashMap<>();
        Set<String> competitorsSet = competitors.stream().map(String::toLowerCase).collect(Collectors.toSet());
        for (String review : reviews) {
            String[] words = review.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
            Set<String> used = new HashSet<>();
            for (String word : words) {
                String lowerWord = word.toLowerCase();
                if (competitorsSet.contains(lowerWord)) {
                    if (used.contains(lowerWord)) continue;
                    else used.add(lowerWord);
                    if (occurrenceOfCompetitorMap.containsKey(lowerWord)) {
                        OccurrenceOfCompetitor occurrenceOfCompetitor = occurrenceOfCompetitorMap.get(lowerWord);
                        occurrenceOfCompetitor.value = occurrenceOfCompetitor.value + 1;
                        occurrenceOfCompetitorMap.put(lowerWord, occurrenceOfCompetitor);
                    }
                    else {
                        occurrenceOfCompetitorMap.put(lowerWord, new OccurrenceOfCompetitor(lowerWord, 1));
                    }
                }
            }
        }
        return occurrenceOfCompetitorMap;
    }
    private class OccurrenceOfCompetitor implements Comparable<OccurrenceOfCompetitor> {
        String name;
        Integer value;

        public OccurrenceOfCompetitor(String name, Integer value) {
            this.name = name;
            this.value = value;
        }

        @Override
        public int compareTo(OccurrenceOfCompetitor occurrenceOfCompetitor) {
            if (value == null || occurrenceOfCompetitor.value == null) {
                return 0;
            }
            int compare = value.compareTo(occurrenceOfCompetitor.value);
            if (compare == 0) {
                return name.compareTo(occurrenceOfCompetitor.name);
            }
            else {
                return compare * -1;
            }
        }
    }
}
