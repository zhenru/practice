package org.muzhe.lambada.ch5.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author muzhe-wang on  18-10-11 下午1:12.
 */

@Data
@AllArgsConstructor
public class Transaction {

    private Trader trader;

    private int year;

    private int value;
}
