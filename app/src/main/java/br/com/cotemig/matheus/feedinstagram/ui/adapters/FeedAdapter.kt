package br.com.cotemig.matheus.feedinstagram.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.cotemig.matheus.feedinstagram.R
import br.com.cotemig.matheus.feedinstagram.models.User
import coil.load
import org.w3c.dom.Text

class FeedAdapter (var context: Context, var list: List<User>) : BaseAdapter() {

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return 0
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_lista, null)

        var user = view.findViewById<TextView>(R.id.user)
        user.text = list[p0].user

        var image = view.findViewById<ImageView>(R.id.image_user)
        image.load(list[p0].image)

        var description = view.findViewById<TextView>(R.id.user_description)
        description.text = list[p0].description

        return view
    }
}