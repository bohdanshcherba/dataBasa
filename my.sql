USE labor_sql;

SELECT `name`, launched FROM ships WHERE launched BETWEEN 1920 AND 1942 ORDER BY launched DESC;

SELECT * FROM trip WHERE time_out BETWEEN '1900-01-01 12:00:00' AND '1900-01-01 17:00:00' ORDER BY time_out;


SELECT model,model, ram, hd FROM laptop GROUP BY 2;
 

SELECT c.country,
       s.class
FROM ships AS s 
RIGHT JOIN classes AS c ON s.class = c.class
WHERE c.country = 'USA';


SELECT maker FROM product WHERE EXISTS (SELECT model FROM pc WHERE pc.model = product.model);


SELECT AVG(price) AS 'середня ціна = '
FROM laptop ;


SELECT CASE
           WHEN avg(price) < 800 THEN count(model)
           ELSE ''
       END AS COUNT,
       CASE
           WHEN avg(price) < 800 THEN avg(price)
           ELSE ''
       END AS `avg price`
FROM pc
GROUP BY model;


SELECT maker,

  (SELECT min(speed)
   FROM pc
   WHERE speed >500
     AND model = product.model) AS 'min speed'
FROM product
WHERE model = ANY
    (SELECT model
     FROM pc
     WHERE speed > 500 );


SELECT maker,
       CASE
           WHEN `type` = 'laptop' THEN CONCAt('yes (',
                                                (SELECT count(model)
                                                 FROM laptop
                                                 WHERE model = product.model),')')
           ELSE 'no'
       END AS 'laptop'
FROM product;


SELECT product.type,
       product.maker,
       selecion.model,
       selecion.price
FROM product JOIN
  (SELECT model, price
   FROM laptop
   WHERE model = ANY
       (SELECT model
        FROM product
        WHERE maker = "B")
   UNION ALL SELECT model, price
   FROM pc
   WHERE model = ANY
       (SELECT model
        FROM product
        WHERE maker = "B")
   UNION ALL SELECT model, price
   FROM printer
   WHERE model = ANY
       (SELECT model
        FROM product
        WHERE maker = "B") ) AS selecion ON product.model = selecion.model ;
        
        
        