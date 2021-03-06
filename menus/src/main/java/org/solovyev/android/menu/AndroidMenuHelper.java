/*
 * Copyright 2013 serso aka se.solovyev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Contact details
 *
 * Email: se.solovyev@gmail.com
 * Site:  http://se.solovyev.org
 */

package org.solovyev.android.menu;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

import javax.annotation.Nonnull;

/**
 * User: serso
 * Date: 8/4/12
 * Time: 2:51 PM
 */
public final class AndroidMenuHelper implements MenuHelper<Menu, MenuItem> {

	@Nonnull
	private static final AndroidMenuHelper instance = new AndroidMenuHelper();

	@Nonnull
	public static MenuHelper<Menu, MenuItem> getInstance() {
		return instance;
	}

	private AndroidMenuHelper() {
	}

	@Override
	public int size(@Nonnull Menu menu) {
		return menu.size();
	}

	@Nonnull
	@Override
	public MenuItem add(@Nonnull Menu menu, int groupId, int itemId, int orderId, @Nonnull String caption) {
		return menu.add(groupId, itemId, orderId, caption);
	}

	@Override
	public void setOnMenuItemClickListener(@Nonnull final MenuItem menuItem, @Nonnull final AMenuItem<MenuItem> onMenuItemClick, @Nonnull final Activity activity) {
		menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				onMenuItemClick.onClick(menuItem, activity);
				return true;
			}
		});
	}

	@Override
	public void removeItem(@Nonnull Menu menu, @Nonnull Integer menuItemId) {
		menu.removeItem(menuItemId);
	}

	@Override
	public void inflateMenu(@Nonnull Activity activity, int layoutId, @Nonnull Menu menu) {
		activity.getMenuInflater().inflate(layoutId, menu);
	}

	@Nonnull
	@Override
	public Integer getItemId(@Nonnull MenuItem item) {
		return item.getItemId();
	}
}
