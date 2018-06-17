/*
 * Copyright (C) 2018 Lalitesh Sahoo (lsdevloper@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.lalitesh.datenoteapp.commons.api;

import it.feio.android.omninotes.commons.listeners.DataRetrievedListener;
import com.lalitesh.datenoteapp.commons.models.Attachment;
import com.lalitesh.datenoteapp.commons.models.Category;
import com.lalitesh.datenoteapp.models.Note;

public interface ONCloudApi {

    public static final String NOTES_FOLDER = "notes";
    public static final String CATEGORIES_FOLDER = "categories";
    public static final String ATTACHMENTS_FOLDER = "attachments";

    public void getNotes(DataRetrievedListener dataRetrievedListener);
    public Note getNote(String noteId);
    public void putNote(Note note);
    public void delNote(Note note);

    public void getCategories(DataRetrievedListener dataRetrievedListener);
    public Category getCategory(String categoryId);
    public void putCategory(Category category);
    public void delCategory(Category category);

    public void getAttachments(DataRetrievedListener dataRetrievedListener);
    public Attachment getAttachment(String attachmentId);
    public void putAttachment(Attachment attachment);
    public void delAttachment(Attachment attachment);

    public void purge();
}

