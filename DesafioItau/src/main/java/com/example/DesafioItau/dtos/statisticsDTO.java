package com.example.DesafioItau.dtos;

public class statisticsDTO {

    private long count; // Quantidade de transações
    private double sum; // Soma total dos valores
    private double avg; // Média dos valores
    private double min; // Menor valor
    private double max; // Maior valor

    // Construtor padrão
    public statisticsDTO() {}

    // Construtor com todos os campos
    public statisticsDTO(long count, double sum, double avg, double min, double max) {
        this.count = count;
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }
}
