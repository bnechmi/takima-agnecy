-- Insertion des voyages
INSERT INTO public.travel VALUES
(1, 'To Tokyo', 'CDG', 'NRT', NOW(), NOW() + INTERVAL '7 days', 'Paris', 10, 1500.00),
(2, 'To New York', 'HND', 'EWR', NOW(), NOW() + INTERVAL '10 days', 'New York', 5, 1800.00),
(3, 'To LA', 'ORY', 'JFK', NOW(), NOW() + INTERVAL '5 days', 'Los Angeles', 20, 1200.00),
(4, 'To Paris', 'LGA', 'ORY', NOW(), NOW() + INTERVAL '8 days', 'London', 15, 1400.00);

-- Insertion des utilisateurs
INSERT INTO public.user VALUES
(1, 'Alice', 'Johnson', 'alice.johnson@example.com'),
(2, 'Bob', 'Smith', 'bob.smith@example.com'),
(3, 'Elena', 'Rodriguez', 'elena.rodriguez@example.com'),
(4, 'Michael', 'Brown', 'michael.brown@example.com');
