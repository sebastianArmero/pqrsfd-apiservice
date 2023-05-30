package com.smartcampus.services;

import java.util.List;

public interface IEntityService<E, I> {

	public void create(E r);

	public void update(I id, E r);

	public void delete(I id);

	public List<E> showAll();

	public E showById(I id);

}
