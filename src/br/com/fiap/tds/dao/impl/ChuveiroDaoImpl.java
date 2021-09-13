package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Chuveiro;
import br.com.fiap.tds.dao.ChuveiroDao;

public class ChuveiroDaoImpl extends GenericDaoImpl<Chuveiro, Integer>
				implements ChuveiroDao{

	public ChuveiroDaoImpl(EntityManager em) {
		super(em);
	}

}
