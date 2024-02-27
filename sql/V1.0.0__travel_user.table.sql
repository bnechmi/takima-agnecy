CREATE TABLE public.travel
(
  id                   BIGSERIAL PRIMARY KEY,
  name                 VARCHAR      NOT NULL,
  departure_airport    VARCHAR    NOT NULL,
  arrival_airport      VARCHAR    NOT NULL,
  departure_date       TIMESTAMP    NOT NULL,
  arrival_date         TIMESTAMP    NOT NULL,
  destination          VARCHAR      NOT NULL,
  capacity             INT          NOT NULL,
  price                DOUBLE PRECISION NOT NULL
);

CREATE TABLE public.user
(
    id                  BIGSERIAL PRIMARY KEY,
    first_name          VARCHAR          NOT NULL,
    last_name          VARCHAR          NOT NULL,
    email               VARCHAR          NOT NULL
);

ALTER SEQUENCE travel_id_seq RESTART 100000 INCREMENT BY 50;
ALTER SEQUENCE user_id_seq RESTART 100000 INCREMENT BY 50;

CREATE TABLE public.reservation
(
    travel_id           BIGINT       NOT NULL,
    user_id             BIGINT       NOT NULL,
    PRIMARY KEY (travel_id, user_id),
    FOREIGN KEY (travel_id) REFERENCES public.travel (id),
    FOREIGN KEY (user_id) REFERENCES public.user (id)
);

CREATE TABLE public.wait_list
(
    travel_id           BIGINT       NOT NULL,
    user_id             BIGINT       NOT NULL,
    priority            INTEGER      NOT NULL,
    PRIMARY KEY (travel_id, user_id),
    FOREIGN KEY (travel_id) REFERENCES public.travel (id),
    FOREIGN KEY (user_id) REFERENCES public.user (id)
);
