CREATE OR REPLACE PROCEDURE PerformFundTransfer(
  sender_acc IN NUMBER,
  receiver_acc IN NUMBER,
  transfer_amt IN NUMBER
) IS
  ex_low_balance EXCEPTION;
  available_balance NUMBER;
BEGIN
  -- Validate sufficient funds
  SELECT balance INTO available_balance
  FROM accounts
  WHERE account_id = sender_acc;

  IF available_balance < transfer_amt THEN
    RAISE ex_low_balance;
  END IF;

  -- Deduct from sender
  UPDATE accounts
  SET balance = balance - transfer_amt
  WHERE account_id = sender_acc;

  -- Add to receiver
  UPDATE accounts
  SET balance = balance + transfer_amt
  WHERE account_id = receiver_acc;

  DBMS_OUTPUT.PUT_LINE('💸 ₹' || transfer_amt || ' transferred from Account ' ||
                        sender_acc || ' to Account ' || receiver_acc);
  COMMIT;

EXCEPTION
  WHEN ex_low_balance THEN
    DBMS_OUTPUT.PUT_LINE('❗Transfer failed: Insufficient funds in Account ' || sender_acc);
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('❗Transfer failed: Invalid account ID(s)');
END;
/
