CREATE OR REPLACE PROCEDURE ApplyMonthlyInterest IS
BEGIN
  FOR acc_row IN (
    SELECT account_id, balance FROM accounts WHERE account_type = 'SAVINGS'
  ) LOOP
    UPDATE accounts
    SET balance = balance + (balance * 0.01)
    WHERE account_id = acc_row.account_id;

    DBMS_OUTPUT.PUT_LINE('📈 Interest credited to Account ID: ' || acc_row.account_id);
  END LOOP;

  COMMIT;
END;
/
