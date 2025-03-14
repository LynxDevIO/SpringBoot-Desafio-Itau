package dev.phil.desafioitau.dto;

import java.util.DoubleSummaryStatistics;

public class StatisticsDto {
    private long count;
    private double sum;
    private double max;
    private double min;

    public StatisticsDto(DoubleSummaryStatistics statistics) {
        this.count = statistics.getCount();
        this.sum = statistics.getSum();
        this.max = statistics.getMax();
        this.min = statistics.getMin();
    }

    public long getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }
}
