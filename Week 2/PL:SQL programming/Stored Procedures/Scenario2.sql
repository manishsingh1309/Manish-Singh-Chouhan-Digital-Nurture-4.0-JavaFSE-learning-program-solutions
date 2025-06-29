CREATE OR REPLACE PROCEDURE AdjustEmployeeBonus(
  dept_name IN VARCHAR2,
  bonus_rate IN NUMBER
) IS
BEGIN
  UPDATE employees
  SET salary = salary + (salary * bonus_rate / 100)
  WHERE department = dept_name;

  DBMS_OUTPUT.PUT_LINE('💼 Bonus successfully added for department: ' || dept_name);
  COMMIT;
END;
/
