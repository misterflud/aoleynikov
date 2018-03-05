package ru.aoleynikov.controller;





import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.aoleynikov.model.AnonUser;
import ru.aoleynikov.model.BaseUser;
import ru.aoleynikov.model.GeteerRole;
import ru.aoleynikov.model.Role;
import ru.aoleynikov.model.User;
import ru.aoleynikov.service.Service;


/**
 * Created by Anton on 29.06.2017.
 */
@Controller
public class UsersController
{


	/**
	 *
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/start")
	public String regStart(final ModelMap model)
	{
		model.addAttribute("ad", "ad"); // добавили аттрибут ad со значением ad
		return "RegView";
	}


	/**
	 *
	 * @param login
	 * @param password
	 * @param model
	 * @param request
	 * @return
	 */
	//@RequestParam(value="login", required = true) String login,
	@PostMapping(value = "/start")
	public String regAuth(@RequestParam(value = "login", required = true) final String login,
			@RequestParam(value = "password", required = true) final String password, final ModelMap model,
			final HttpServletRequest request)
	{
		final AnonUser anonUser = new AnonUser(login, password);
		final Service service = new Service();
		if (service.authUser(anonUser))
		{
			//    		System.out.println("2");
			final BaseUser authUser = service.get(anonUser);
			request.getSession().setAttribute("authUser", authUser);

			return "redirect:users";
		}
		model.addAttribute("error", "Wrong login or password");
		return "RegView";
	}

	/**
	 *
	 * @return
	 */
	@GetMapping(value = "/users")
	public String usersStart()
	{
		return "UsersView";
	}

	/**
	 *
	 * @param login
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/getUser")
	public String usersShowUser(@RequestParam(value = "login", required = true) final String login, final ModelMap model,
			final HttpServletRequest request)
	{
		boolean sameUser = false;
		boolean isAdmin = false;
		final Service service = new Service();

		final BaseUser userFromView = service.get(new User(request.getParameter("login")));
		final BaseUser userFromSession = ((BaseUser) request.getSession().getAttribute("authUser"));
		if (userFromView.equals(userFromSession))
		{
			sameUser = true;
		}

		if (userFromSession.getUserRole().getId() == 1)
		{
			isAdmin = true;
		}
		model.addAttribute("getEditUser", userFromView);
		model.addAttribute("sameUser", sameUser);
		model.addAttribute("isAdmin", isAdmin);


		System.out.println(login);

		return "UsersView";
	}

	/**
	 *
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/getUsers")
	public String usersShowUsers(final ModelMap model)
	{
		final Service service = new Service();
		model.addAttribute("listUser", service.getAll());
		return "UsersView";
	}

	@PostMapping(value = "/saveEdit")
	public String editUser(@RequestParam final Map<String, String> queryMap)
	{
		final Service service = new Service();
		final String name = queryMap.get("name");
		final String login = queryMap.get("login");
		final String email = queryMap.get("email");
		final String password = queryMap.get("password");
		final int id = Integer.parseInt((queryMap.get("userRole")));

		final Role role = (new GeteerRole()).getRole(id);
		final BaseUser editUser = new AnonUser(name, login, email, password, role);
		service.editUser(editUser);
		return "redirect:/users";
	}

	@PostMapping(value = "/deleteUser")
	public String delete(@RequestParam("login") final String login)
	{
		final Service service = new Service();
		final BaseUser user = service.get(new AnonUser(login));
		service.deleteUser(user);
		return "redirect:/users";
	}

	/**
	 *
	 * @param request
	 * @return
	 */
	@GetMapping(value = "/add")
	public String add(final HttpServletRequest request, final ModelMap model)
	{
		boolean adminOrNot = false;
		if (((BaseUser) request.getSession().getAttribute("authUser")).getUserRole().getId() == 1)
		{
			adminOrNot = true;
		}
		model.addAttribute("adminOrNot", adminOrNot);
		return "AddUsers";
	}

	/**
	 *
	 * @param queryMap
	 * @return
	 */
	@PostMapping(value = "/addUser")
	public String addUser(@RequestParam final Map<String, String> queryMap)
	{
		final Service service = new Service();
		final String name = queryMap.get("name");
		final String login = queryMap.get("login");
		final String email = queryMap.get("email");
		final String password = queryMap.get("password");
		final int id = Integer.parseInt((queryMap.get("role_id")));

		final Role role = (new GeteerRole()).getRole(id);
		final BaseUser user = new AnonUser(name, login, email, password, role);
		service.addUser(user);
		return "redirect:/add";
	}
}
