import __practice.Account;
import __practice.NaturalNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AccountTest {

    @Test
    @DisplayName(("계좌를 생성하고 1000원을 입금하면 잔액이 1000원이 된다."))
    void deposit() {
        Account account = Account.createWithBalance(NaturalNumber.from(1000));

        assertThat(account.getBalance()).isEqualTo(1000);
    }

    @Test
    @DisplayName("10000원이 있는 계좌에서 3000원을 출금하면 7000원이 남는다.")
    void withdraw_success() {
        //given
        Account account = Account.createWithBalance(NaturalNumber.from(10000));
        //when
        account.withdraw(NaturalNumber.from(3000));
        //then
        assertThat(account.getBalance()).isEqualTo(7000);
    }

    @Test
    @DisplayName("잔액보다 많은 출금하면 예외가 발생한다.")
    void withdraw_throw_exception() throws Exception {
    //given
    Account account = Account.createWithBalance(NaturalNumber.from(10000));

    //when & then
    assertThatThrownBy(() -> account.withdraw(NaturalNumber.from(12000)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("음수 금액을 입금하면 예외가 발생한다.")
    void deposit_negative_amount_throw_exception () throws Exception {
    //given
        Account account = Account.createEmptyAccount();
    //when & //then
        assertThatThrownBy(() -> account.deposit(NaturalNumber.from(-1000)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}