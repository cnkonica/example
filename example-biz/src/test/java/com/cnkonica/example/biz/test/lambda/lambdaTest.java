package com.cnkonica.example.biz.test.lambda;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class lambdaTest {

    @Test
    public void test01(){
        List<Loan> loans = Arrays.asList(
                new Loan("cf001","1",new BigDecimal("1000"),new BigDecimal("45"),"2020-01-03"),
                new Loan("cf001","2",new BigDecimal("500"),new BigDecimal("45"),"2020-02-04"),
                new Loan("cf001","2",new BigDecimal("200"),new BigDecimal("45"),"2020-02-05"));

        List<Loan> collect = loans.stream().collect(Collectors.collectingAndThen(
                Collectors.toMap(x -> new GroupKey(x.getLoanno(), x.getTrn()), Function.identity(),
                        (l1, l2) -> {
                            l2.setAmount(l1.getAmount().add(l2.getAmount()));
                            l2.setInte(l1.getInte().add(l2.getInte()));
                            return l2;
                        }), map -> new ArrayList(map.values())
        ));
        collect.forEach(x-> System.out.println("1"+x));
        collect.addAll(Collections.singletonList(new Loan("cf001", "2", new BigDecimal("100"), new BigDecimal("10"), "2020-02-03")));
        collect.forEach(x-> System.out.println("2"+x));

        Optional<Loan> loan = collect.stream().filter(x -> StringUtils.equals(x.getLoanno(), "cf001"))
                .filter(x -> StringUtils.equals(x.getTrn(), "2"))
                .max(Comparator.comparing(x -> x.getDueDate()));

        loan.ifPresent(x-> System.out.println(x));

    }

    static class GroupKey{
        private String loanno;
        private String trn;

        public GroupKey(String loanno, String trn) {
            this.loanno = loanno;
            this.trn = trn;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GroupKey groupKey = (GroupKey) o;
            return Objects.equals(loanno, groupKey.loanno) &&
                    Objects.equals(trn, groupKey.trn);
        }

        @Override
        public int hashCode() {
            return Objects.hash(loanno, trn);
        }
    }

    static class Loan{
        private String loanno;
        private String trn;
        private BigDecimal amount;
        private BigDecimal inte;
        private String dueDate;

        public Loan(String loanno, String trn, BigDecimal amount, BigDecimal inte, String dueDate) {
            this.loanno = loanno;
            this.trn = trn;
            this.amount = amount;
            this.inte = inte;
            this.dueDate = dueDate;
        }

        public String getLoanno() {
            return loanno;
        }

        public void setLoanno(String loanno) {
            this.loanno = loanno;
        }

        public String getTrn() {
            return trn;
        }

        public void setTrn(String trn) {
            this.trn = trn;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public BigDecimal getInte() {
            return inte;
        }

        public void setInte(BigDecimal inte) {
            this.inte = inte;
        }

        public String getDueDate() {
            return dueDate;
        }

        public void setDueDate(String dueDate) {
            this.dueDate = dueDate;
        }

        @Override
        public String toString() {
            return "Loan{" +
                    "loanno='" + loanno + '\'' +
                    ", trn='" + trn + '\'' +
                    ", amount=" + amount +
                    ", inte=" + inte +
                    ", dueDate='" + dueDate + '\'' +
                    '}';
        }
    }

}
