BEGIN
  FOR customerRecord IN (
    SELECT customer_id FROM customers WHERE balance > 10000
  ) LOOP
    UPDATE customers
    SET is_vip = 'Y'
    WHERE customer_id = customerRecord.customer_id;

    DBMS_OUTPUT.PUT_LINE('✅ VIP Status Assigned: Customer ID - ' || customerRecord.customer_id);
  END LOOP;

  COMMIT;
END;
/
