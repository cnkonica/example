-- 建表
CREATE TABLE if not exists public.employee
(
  id serial primary key,
  cert_id varchar(100) not null,
  name varchar(100) default NULL,
  gender varchar(10) default NULL,
  age int default NULL,
  deleted boolean default false,
  created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
  created_by character varying(100) DEFAULT 'system',
  updated_date timestamp without time zone DEFAULT NULL,
  update_by character varying(100) DEFAULT NULL
);

-- 注释
COMMENT ON TABLE public.employee IS '用户表';
COMMENT ON COLUMN public.employee.id IS '主键';
COMMENT ON COLUMN public.employee.cert_id IS '身份证';
COMMENT ON COLUMN public.employee.name IS '姓名';
COMMENT ON COLUMN public.employee.gender IS '性别';
COMMENT ON COLUMN public.employee.deleted IS '删除标志';
COMMENT ON COLUMN public.employee.age IS '年龄';
COMMENT ON COLUMN public.employee.created_date IS '创建时间';
COMMENT ON COLUMN public.employee.created_by IS '创建人';
COMMENT ON COLUMN public.employee.updated_date IS '更新时间';
COMMENT ON COLUMN public.employee.update_by IS '更新人';


-- 索引或唯一索引
drop index if exists idx_user_name;
CREATE INDEX idx_user_name ON employee (name);

drop index if exists idx_cert_id;
CREATE  UNIQUE INDEX idx_cert_id ON employee (cert_id);

-- 授权
--GRANT ALL ON TABLE public.employee TO mydata;
--GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE public.employee TO mydata_dml;
--GRANT SELECT ON TABLE public.employee TO mydata_qry;
