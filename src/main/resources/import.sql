--
-- JBoss, Home of Professional Open Source
-- Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- You can use this file to load seed data into the database using SQL statements
insert into Member (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212') 

-- Product
insert into Product(id, name, description, price, stock) values(101, 'Cat food', 'Food for cats', 1.95, 100)
insert into Product(id, name, description, price, stock) values(102, 'Dog food', 'Food for dogs', 2.95, 100)
insert into Product(id, name, description, price, stock) values(103, 'Bird food', 'Food for birds', 3.95, 100)
insert into Product(id, name, description, price, stock) values(104, 'Bowl', 'To eat food', 4.95, 100)
insert into Product(id, name, description, price, stock) values(105, 'Cage', 'Because birds need cages', 5.95, 100)

-- Category
insert into Category(id, name, description) values(1, 'Cat', 'All cat related products')
insert into Category(id, name, description) values(2, 'Dog', 'All dog related products')
insert into Category(id, name, description) values(3, 'Birds', 'All bird related products')
