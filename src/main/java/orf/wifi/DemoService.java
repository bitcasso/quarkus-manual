package orf.wifi;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DemoService {

    public String reverse(String input){
       return new StringBuilder(input.replace(" ","")).reverse().toString();
    }

    public Boolean isPalindrom(String candidate){
        return candidate.replace(" ","").equals(reverse(candidate));
    }

    public Boolean isAnagram(String input, String secondinput) {
        Map<Integer, Long> counted = input.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> secondCounted = secondinput.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return counted.keySet().containsAll(secondCounted.keySet()) && secondCounted.keySet().containsAll(counted.keySet()) &&
                counted.entrySet().stream().allMatch(entry -> secondCounted.get(entry.getKey()).equals(entry.getValue()));
    }
}
