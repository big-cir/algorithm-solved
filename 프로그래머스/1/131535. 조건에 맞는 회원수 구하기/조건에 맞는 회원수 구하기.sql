select count(USER_ID) as USERS
from USER_INFO
where date_format(JOINED, '%Y') = 2021 and AGE >= 20 and AGE <= 29 


# SELECT COUNT(user_id) as users
# FROM user_info
# WHERE YEAR(joined) = '2021' AND age >= 20 AND age <= 29;